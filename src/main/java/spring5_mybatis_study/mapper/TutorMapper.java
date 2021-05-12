package spring5_mybatis_study.mapper;

import spring5_mybatis_study.dto.Tutor;

public interface TutorMapper {
	Tutor selectTutorByTutorId(Tutor tutor);
}
