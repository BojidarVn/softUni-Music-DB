package bg.softuni.musicdb.WEB;

import bg.softuni.musicdb.model.binding.AlbumBindingModel;
import bg.softuni.musicdb.repository.AlbumRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/albums")
@RestController
public class AlbumRestController {

    private final AlbumRepository albumRepository;
    private final ModelMapper modelMapper;

    public AlbumRestController(AlbumRepository albumRepository, ModelMapper modelMapper) {
        this.albumRepository = albumRepository;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/api")
    public List<AlbumBindingModel> findAll() {

        albumRepository
                .findAll()
                .stream()
                .map(ae ->modelMapper.map(ae, AlbumBindingModel.class))
                .collect(Collectors.toList());

        //TODO
        throw new UnsupportedOperationException();
    }
}
