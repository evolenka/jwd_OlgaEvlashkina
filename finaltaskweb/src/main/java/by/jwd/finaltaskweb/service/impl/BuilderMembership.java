package by.jwd.finaltaskweb.service.impl;

import java.time.LocalDate;

import by.jwd.finaltaskweb.entity.Client;
import by.jwd.finaltaskweb.entity.Membership;
import by.jwd.finaltaskweb.entity.MembershipType;


public class BuilderMembership {
	
	public Membership buildMembership (Client client, MembershipType type,	LocalDate startDate, LocalDate endDate) {
			
		Membership membership= new Membership();
		
		membership.setClient(client);
		membership.setType(type);
		membership.setStartDate(startDate);
		membership.setEndDate(endDate);
		membership.setBalanceClassQuantity(type.getMaxClassQuantity());
		
		return membership;
	}
}