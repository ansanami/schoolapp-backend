package tr.ogu.edu.school.schoolapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.ogu.edu.school.schoolapp.model.Yemekhane;
import tr.ogu.edu.school.schoolapp.repository.YemekhaneRepository;

import java.util.List;
import java.util.Optional;

@Service
public class YemekhaneService {

    @Autowired
    private YemekhaneRepository yemekhaneRepository;

    public List<Yemekhane> getAllYemekhaneEntries() {
        return yemekhaneRepository.findAll();
    }

    public Optional<Yemekhane> getYemekhaneEntryById(Long id) {
        return yemekhaneRepository.findById(id);
    }

    public Yemekhane createYemekhaneEntry(Yemekhane yemekhane) {
        return yemekhaneRepository.save(yemekhane);
    }

    public Yemekhane updateYemekhaneEntry(Long id, Yemekhane yemekhaneDetails) {
        Optional<Yemekhane> optionalYemekhane = yemekhaneRepository.findById(id);
        if (optionalYemekhane.isPresent()) {
            Yemekhane existingYemekhane = optionalYemekhane.get();
            existingYemekhane.setGun(yemekhaneDetails.getGun());
            existingYemekhane.setYemek1(yemekhaneDetails.getYemek1());
            existingYemekhane.setYemek2(yemekhaneDetails.getYemek2());
            existingYemekhane.setYemek3(yemekhaneDetails.getYemek3());
            existingYemekhane.setYemek4(yemekhaneDetails.getYemek4());
            return yemekhaneRepository.save(existingYemekhane);
        } else {
            throw new RuntimeException("Yemekhane entry not found with id " + id);
        }
    }

    public void deleteYemekhaneEntry(Long id) {
        yemekhaneRepository.deleteById(id);
    }
}
