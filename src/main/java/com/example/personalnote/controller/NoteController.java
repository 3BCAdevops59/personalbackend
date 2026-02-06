package com.example.personalnote.controller;

import com.example.personalnote.model.Note;
import com.example.personalnote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*", maxAge = 3600)
public class NoteController {

    @Autowired
    private NoteService noteService;

    /**
     * GET /api/notes - Get all notes
     */
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    /**
     * GET /api/notes/{id} - Get a note by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> note = noteService.getNoteById(id);
        return note.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * POST /api/notes - Create a new note
     */
    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        if (note.getTitle() == null || note.getTitle().isEmpty() ||
            note.getContent() == null || note.getContent().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        Note createdNote = noteService.createNote(note);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNote);
    }

    /**
     * PUT /api/notes/{id} - Update a note
     */
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        Optional<Note> updatedNote = noteService.updateNote(id, noteDetails);
        return updatedNote.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * DELETE /api/notes/{id} - Delete a note
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        if (noteService.deleteNote(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * DELETE /api/notes - Delete all notes
     */
    @DeleteMapping
    public ResponseEntity<Void> deleteAllNotes() {
        noteService.deleteAllNotes();
        return ResponseEntity.noContent().build();
    }
}
