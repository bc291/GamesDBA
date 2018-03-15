package com.bc291.database.test;

import com.bc291.database.database.DatabaseHelper;
import com.bc291.database.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ApplicationStartup
        implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    GameRepository gameRepository;

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
       // JpaRepositoryFactory jpaRepositoryFactory = new JpaRepositoryFactory(entityManager);
        //yourRepository = jpaRepositoryFactory.getRepository(GameRepository.class);

        DatabaseHelper databaseHelper = new DatabaseHelper();

        Scanner scanner = new Scanner(System.in);
        String input;


//        do{
//
//            System.out.printf("Podaj nazwe gry: ");
//            input = scanner.nextLine();
//            if(input.equals("0")) break;
//            jsonFromGol test = databaseHelper.resolveJson(input);
//            gameRepository.save(databaseHelper.addToDatabase(test));
//
//
//        } while(!input.equals("0"));
//
//
//
//        System.out.println(gameRepository);


        return;
    }

}