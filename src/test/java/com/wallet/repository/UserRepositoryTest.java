package com.wallet.repository;

import com.wallet.entity.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    private static final String EMAIL = "email@teste.com";

    @Autowired
    UserRepository repository;

    @Before
    public void setup(){
        User u = new User();
        u.setName("Setup User");
        u.setPassword("Senha123");
        u.setEmail(EMAIL);

        repository.save(u);
    }

    @After
    public void teardown(){
        repository.deleteAll();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setName("Teste");
        user.setPassword("123456");
        user.setEmail("teste@teste.com");

        User response = repository.save(user);

        Assert.assertNotNull(response);
    }

    @Test
    public void testFindByEmail(){
        Optional<User> response = repository.findByEmailEquals(EMAIL);

        Assert.assertTrue(response.isPresent());
        Assert.assertEquals(response.get().getEmail(), EMAIL);
    }
}
