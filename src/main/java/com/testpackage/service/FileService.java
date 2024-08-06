package src.main.java.com.testpackage.service;

import src.main.java.com.testpackage.entity.FileEntity;
import src.main.java.com.testpackage.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public FileEntity saveFile(FileEntity file) {
        return fileRepository.save(file);
    }

    public Optional<FileEntity> getFile(Long id) {
        return fileRepository.findById(id);
    }

    public List<FileEntity> getAllFiles() {
        return fileRepository.findAll();
    }

    public boolean deleteFile(Long id) {
        if (fileRepository.existsById(id)) {
            fileRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
