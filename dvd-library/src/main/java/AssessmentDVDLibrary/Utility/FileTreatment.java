package AssessmentDVDLibrary.Utility;

import AssessmentDVDLibrary.Model.DVD;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileTreatment
{
    File file;
    public FileTreatment(File file) {
        this.file = file;
    }
    public List<DVD> readFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        List<DVD> DVDs = mapper.readValue(file, new TypeReference<List<DVD>>() {});
        return DVDs;
    }

    public void addToFile(List<DVD> dvds) throws IOException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(dvds);
        Files.write(Paths.get(file.getPath()),json.getBytes());
    }
}
