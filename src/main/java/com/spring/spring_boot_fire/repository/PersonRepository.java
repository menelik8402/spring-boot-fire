package com.spring.spring_boot_fire.repository;

import com.spring.spring_boot_fire.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

    @Query(
            value = "SELECT  * FROM people p inner join person_has_trip ph on ph.people_idperson=p.id_person " +
                    " inner join trips t on ph.trip_idtrip = t.id_trip " +
                    " inner join address a on t.address_id= a.id_address " +
                    " where country = :country ",nativeQuery = true)
    public List<Person> getListOfPeopleTripTo(@Param("country") String country);

    @Query(
            value = "SELECT  * FROM people p inner join person_has_trip ph on ph.people_idperson=p.id_person " +
                    " inner join trips t on ph.trip_idtrip = t.id_trip " +
                    " inner join address a on t.address_id= a.id_address " +
                    "inner join hotels h  on h.address_id = a.id_address" +
                    " where h.category = :cat ",nativeQuery = true)
    public List<Person> getListOfPeopleStayTopHoltel(@Param("cat")  int category);

    @Query(
            value = "SELECT count(*) as cantidad FROM public.people p " +
                    "inner join person_has_house ph on p.id_person = ph.people_idperson " +
                    "inner join houses h on ph.house_idhouse = h.id_house " +
                    "where h.color = :color ",nativeQuery = true)
    public Integer getCountOfBlueHouses(@Param("color")  String color);

    @Query(
            value = "SELECT  * FROM people p inner join person_has_trip ph on ph.people_idperson=p.id_person " +
                    "inner join trips t on ph.trip_idtrip = t.id_trip " +
                    "inner join address a on t.address_id= a.id_address " +
                    "inner join hotels h  on h.address_id = a.id_address " +
                    "inner join houses ho on a.id_address = ho.id_house " +
                    "where country = :country and h.category = :cat and " +
                    "a.province = :province and t.DATE BETWEEN cast(:yearIni AS TIMESTAMP) and cast(:yearFinal AS TIMESTAMP) ",nativeQuery = true)
    public List<Person> getListOfPeopleTripToStayHotelHouses(
                        @Param("country") String country,
                        @Param("cat") int cat,
                        @Param("province") String province,
                        @Param("yearIni") String yearIni,
                        @Param("yearFinal") String yearFinal);
}


