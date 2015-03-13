package cu.uci.abcd.domain.acquisition;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MaterialCopy {
	@Column(name = "title_copy", nullable = false, length = 150)
	private String titleCopy;
	@Column(name = "author_copy", length = 150)
	private String authorCopy;
	@Column(name = "editorial", length = 150)
	private String editorial;
	@Column(name = "copyright_date", nullable = false)
	private Date copyrightDate;

	public String getTitleCopy() {
		return titleCopy;
	}

	public void setTitleCopy(String titleCopy) {
		this.titleCopy = titleCopy;
	}

	public String getAuthorCopy() {
		return authorCopy;
	}

	public void setAuthorCopy(String authorCopy) {
		this.authorCopy = authorCopy;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Date getCopyrightDate() {
		return copyrightDate;
	}

	public void setCopyrightDate(Date copyrightDate) {
		this.copyrightDate = copyrightDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authorCopy == null) ? 0 : authorCopy.hashCode());
		result = prime * result
				+ ((titleCopy == null) ? 0 : titleCopy.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MaterialCopy other = (MaterialCopy) obj;
		if (authorCopy == null) {
			if (other.authorCopy != null)
				return false;
		} else if (!authorCopy.equals(other.authorCopy))
			return false;
		if (titleCopy == null) {
			if (other.titleCopy != null)
				return false;
		} else if (!titleCopy.equals(other.titleCopy))
			return false;
		return true;
	}

}
