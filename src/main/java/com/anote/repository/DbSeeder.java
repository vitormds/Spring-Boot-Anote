package com.anote.repository;



import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.anote.model.Note;
import com.anote.model.Notebook;


@Service
public class DbSeeder {
    private @Autowired NotebookRepository notebookRepository;
    private @Autowired NoteRepository noteRepository;

   
    public void instatiateTestDatabase( ) throws ParseException {
      


        // Remove all existing entities
        this.notebookRepository.deleteAll();
        this.noteRepository.deleteAll();


        // Save a default notebook
        Notebook defaultNotebook = new Notebook("Default");
        this.notebookRepository.save(defaultNotebook);


        // Save the welcome note
        Note note = new Note("Hello", "Welcome to Anote", defaultNotebook);
        this.noteRepository.save(note);

    

        System.out.println("Initialized database");
    }

	
		
		
	
}
