package com.example.personalnote.service;

import com.example.personalnote.model.Note;
import com.example.personalnote.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    /**
     * Get all notes
     */
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    /**
     * Get a note by ID
     */
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    /**
     * Create a new note
     */
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    /**
     * Update an existing note
     */
    public Optional<Note> updateNote(Long id, Note noteDetails) {
        Optional<Note> noteOptional = noteRepository.findById(id);
        
        if (noteOptional.isPresent()) {
            Note note = noteOptional.get();
            if (noteDetails.getTitle() != null) {
                note.setTitle(noteDetails.getTitle());
            }
            if (noteDetails.getContent() != null) {
                note.setContent(noteDetails.getContent());
            }
            return Optional.of(noteRepository.save(note));
        }
        
        return Optional.empty();
    }

    /**
     * Delete a note by ID
     */
    public boolean deleteNote(Long id) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Delete all notes
     */
    public void deleteAllNotes() {
        noteRepository.deleteAll();
    }

    /**
     * Get total count of notes
     */
    public long getNotesCount() {
        return noteRepository.count();
    }
}
