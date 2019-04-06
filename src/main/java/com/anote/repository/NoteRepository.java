package com.anote.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anote.model.Note;
import com.anote.model.Notebook;

public interface NoteRepository extends JpaRepository<Note, UUID> {
	List<Note> findAllByNotebook(Notebook notebook);
}
