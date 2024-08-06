package com.testpackage.controller;

import com.testpackage.dto.FileRequestDTO;
import com.testpackage.entity.FileEntity;
import com.testpackage.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponseEntity<Long> createFile(@RequestBody FileRequestDTO fileRequest) {
        FileEntity file = new FileEntity();
        file.setTitle(fileRequest.getTitle());
        file.setCreationDate(fileRequest.getCreationDate());
        file.setDescription(fileRequest.getDescription());
        file.setFileContent(fileRequest.getFileContent());

        FileEntity savedFile = fileService.saveFile(file);
        return ResponseEntity.ok(savedFile.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileEntity> getFile(@PathVariable Long id) {
        Optional<FileEntity> file = fileService.getFile(id);
        return file.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<FileEntity>> getAllFiles() {
        List<FileEntity> files = fileService.getAllFiles();
        return ResponseEntity.ok(files);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFile(@PathVariable Long id) {
        boolean isDeleted = fileService.deleteFile(id);
        if (isDeleted) {
            return ResponseEntity.ok("File deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
