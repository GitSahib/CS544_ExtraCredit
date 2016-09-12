package projects.mum.edu.ea.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Administrator")
public class Administrator extends User {
	@OneToMany(mappedBy="user")
	private List<Offer> offers = new ArrayList<Offer>();;
}
