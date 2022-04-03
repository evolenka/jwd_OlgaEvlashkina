package by.jwd.finaltaskweb.dao;


import java.util.List;
import by.jwd.finaltaskweb.entity.Status;
import by.jwd.finaltaskweb.entity.Visit;

public interface VisitDao extends StudioDao<Integer, Visit>{
	
	public List <Visit> readPlanned () throws DaoException; //select all planned visits 
	
	public Visit readByMembershipAndDanceClass (Integer membershipId, Integer danceClassId) throws DaoException;//select visits of the client for period (see VisitService)
	
	public Visit readByDanceClass (Integer danceClassId) throws DaoException;//select visits of the group for period (see VisitService)
	
	public List <Visit> readPlannedByMembership(Integer membershipId) throws DaoException;//select visits planned by client
	
	public boolean updateStatus (Status status) throws DaoException;
}