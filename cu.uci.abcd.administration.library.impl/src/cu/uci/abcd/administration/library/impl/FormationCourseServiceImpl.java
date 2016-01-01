package cu.uci.abcd.administration.library.impl;

import java.util.Collection;
import java.util.Map;

import cu.uci.abcd.administration.library.IFormationCourseService;
import cu.uci.abcd.dao.management.library.FormationCourseDAO;
import cu.uci.abcd.domain.management.library.FormationCourse;
import cu.uci.abcd.domain.management.library.Library;

/**
 * 
 * @author Yaksel Duran Rivas
 * 
 */
public class FormationCourseServiceImpl implements IFormationCourseService{
	
	private FormationCourseDAO formationCourseDAO;

	public void bind(FormationCourseDAO formationCourseDAO, Map<?, ?> properties) {
		this.formationCourseDAO = formationCourseDAO;
	}

	/**
	 * Requisito funcional Insertar Curso de Formacion
	 * @see IFormationCourseService
	 */
	@Override
	public FormationCourse AddFormationCourse(FormationCourse formationCourse) {
		return formationCourseDAO.save(formationCourse);
	}

	/**
	 * Requisito funcional Buscar Cursos de Formacion
	 * @see IFormationCourseService
	 */
	@Override
	public Collection<FormationCourse> findAll() {
		return (Collection<FormationCourse>) formationCourseDAO.findAll();
	}

	@Override
	public Collection<FormationCourse> findByLibrary(Long idLabrary) {
		return (Collection<FormationCourse>) formationCourseDAO.findDistinctFormationCourseByOwnerLibrary_ActorID(idLabrary);
	}

	@Override
	public void DeleteFormationCourse(Long idFormationCourse) {
		formationCourseDAO.delete(idFormationCourse);
		
	}
}
