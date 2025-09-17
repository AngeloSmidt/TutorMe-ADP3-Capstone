package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Tutor;
import za.ac.cput.factory.TutorFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TutorServiceTest {

    @Autowired
    private TutorService service;

    private static Tutor tutor = TutorFactory.createTutor(
            "Jake",
            "Gerwil",
            "0695739592",
            "gerwil10@gmail.com",
            "Password!123",
            150.00,
            "Advanced diploma student in Applications Development. Here to help others" +
                    "to understand the complexity and beauty of programming",
            4.5,
            true
    );

    @Test
    @Order(1)
    void create() {
        Tutor created = service.create(tutor);
        assertNotNull(created);
        tutor = created;
        assertEquals(tutor.getTutorID(), created.getTutorID()); // extra safety check
        System.out.println("Created: " + created);
    }

    @Test
    @Order(2)
    void read() {
        Tutor read = service.read(tutor.getTutorID());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    @Order(3)
    void update() {
        Tutor newTutor = new Tutor.TutorBuilder()
                .copy(tutor)
                .setFirstName("Jaco") // changed
                .build();

        Tutor updated = service.update(newTutor);
        assertNotNull(updated);
        assertEquals("Jaco", updated.getFirstName());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Order(4)
    void delete() {
        boolean deleted = service.delete(tutor.getTutorID());
        assertTrue(deleted, "Tutor should be deleted");

        Tutor check = service.read(tutor.getTutorID());
        assertNull(check, "Tutor should no longer exist after delete");
        System.out.println("Deleted: " + tutor.getTutorID());
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("All tutors: " + service.getAll());
        assertNotNull(service.getAll());
    }
}
