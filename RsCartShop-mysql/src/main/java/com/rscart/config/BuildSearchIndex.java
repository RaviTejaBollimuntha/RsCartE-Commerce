package com.rscart.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * The only meaning for this class is to build the Lucene index at application
 * startup. This is needed in this example because the database is filled 
 * before and each time the web application is started. In a normal web 
 * application probably you don't need to do this.
 * 
 * @author Ravi Teja Bollimuntha
 */
@Component
public class BuildSearchIndex
implements ApplicationListener<ApplicationReadyEvent> {
  
  // ------------------------
  // PRIVATE FIELDS
  // ------------------------
  
  @PersistenceContext
  private EntityManager entityManager;
  

  // ------------------------
  // PUBLIC METHODS
  // ------------------------

  /**
   * Create an initial Lucene index for the data already present in the
   * database.
   * This method is called when Spring's startup.
   */
  @Override
  public void onApplicationEvent(final ApplicationReadyEvent event) {
    try {
      FullTextEntityManager fullTextEntityManager =
        Search.getFullTextEntityManager(entityManager);
      fullTextEntityManager.createIndexer().startAndWait();
    }
    catch (InterruptedException e) {
      System.out.println(
        "An error occurred trying to build the serach index: " +
         e.toString());
    }
    return;
  }


} // class

