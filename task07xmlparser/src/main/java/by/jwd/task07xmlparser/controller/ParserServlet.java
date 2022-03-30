package by.jwd.task07xmlparser.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.jwd.task07xmlparser.service.BaseBuilder;
import by.jwd.task07xmlparser.service.BuildFactory;
import by.jwd.task07xmlparser.service.ServiceException;

@WebServlet("/start")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class ParserServlet extends HttpServlet {

	private static Logger logger = LogManager.getLogger(ParserServlet.class);

	private static final String UPLOAD_DIRECTORY = "upload";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf8");

		String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;

		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists())
			uploadDir.mkdir();

		String fileName = "";
		String xsdFile = "";
		String filePath = "";

		try {
			for (Part part : request.getParts()) {

				if (part.getName().equals("fileName")) {
					fileName = part.getSubmittedFileName();
					logger.debug("part {}", part.getName());
					filePath = uploadPath + File.separator + fileName;
					part.write(filePath);
				} else if (part.getName().equals("xsdFile")) {
					xsdFile = part.getSubmittedFileName();
					logger.debug("part {}", part.getName());
					filePath = uploadPath + File.separator + xsdFile;
					part.write(filePath);
				}
			}

			String type = request.getParameter("parser");
			logger.debug("type {}", type);
			BaseBuilder builder = BuildFactory.createParser(type);

			try {
				builder.buildSetVisits(uploadPath + File.separator + fileName, uploadPath + File.separator + xsdFile);
			} catch (ServiceException e) {
				logger.error("parsing error");
			}

			request.setAttribute("visits", builder.getVisits());

		} catch (FileNotFoundException e) {
			request.setAttribute("message", "There was an error: " + e.getMessage());
		}
		request.getRequestDispatcher("WEB-INF/jsp/result.jsp").forward(request, response);
	}
}