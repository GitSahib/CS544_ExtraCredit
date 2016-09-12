package projects.mum.edu.ea.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Image {
	@Id @GeneratedValue
	private int id;
	@Lob
	private byte[] image;
}
