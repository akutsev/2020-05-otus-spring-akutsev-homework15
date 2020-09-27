package ru.otus.akutsev.excursions.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.akutsev.excursions.model.Attraction;

@Repository
public interface AttractionsSqlRepository extends JpaRepository<Attraction, Long> {
}
