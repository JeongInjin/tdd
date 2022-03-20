package com.tdd.programmer.mockito;

import com.tdd.programmer.domain.Study;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudyRepository extends JpaRepository<Study, Long> {

}
