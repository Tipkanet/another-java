package tipka.less_0917_working_with_files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Set;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.LocalFileHeader;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static org.assertj.core.api.Assertions.assertThat;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

public class FileContentTests {
    private static final String sourcesFolderPath = "./src/test/resources/";

    @Test
    void txtFileTest() throws Exception {
        String  txtFileName = "simple_text.txt",
                stringFromTextFile = "Apache POI is a Java library";
        String data = new String(Files.readAllBytes(Paths.get(sourcesFolderPath + txtFileName)));
        assertThat(data).contains(stringFromTextFile);
    }

    @Test
    void pdfFileTest() throws Exception {
        String pdfLoadingURL = "https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/";
        Selenide.open(pdfLoadingURL);
        File download = Selenide.$(byText("Download sample pdf file")).download();
        PDF parsed = new PDF(download);
        assertThat(parsed.numberOfPages)
                .isEqualTo(4);
        assertThat(parsed.creator).asString()
                .isEqualTo("Writer");
        assertThat(parsed.text.subSequence(0,11).toString())
                .contains("Lorem ipsum");
    }

    @Test
    void xlsxFileTest() throws Exception {
        String xlsxFileName = "sampledatainsurance.xlsx";
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(xlsxFileName)) {
            XLS parsed = new XLS((Objects.requireNonNull(stream)));
            assertThat(parsed.excel
                    .getSheetAt(0)
                    .getSheetName())
                    .isEqualTo("Instructions");
            assertThat(parsed.excel
                    .getSheetAt(1)
                    .getRow(4)
                    .getCell(0)
                    .getStringCellValue())
                    .isEqualTo("100315");
            assertThat(parsed.excel
                    .getNumberOfSheets())
                    .isEqualTo(3);
        }
    }

    @Test
    void protectedZipFileTest () throws Exception {
        String  zipFileName = "passwordProtectedZipFiles.zip",
                password = "password",
                txtFileName = "password_protected_zip_files.txt",
                stringFromFile = "How to Create Password-Protected Zip Files";

        File zipFile = new File(sourcesFolderPath + zipFileName);
        InputStream inputStream = new FileInputStream(zipFile);
        try (ZipInputStream zipInputStream = new ZipInputStream(inputStream, password.toCharArray())) {
            LocalFileHeader localFileHeader = zipInputStream.getNextEntry();
            File extractedFile = new File(localFileHeader.getFileName());
            assertThat(extractedFile.getName()).isEqualTo(txtFileName);
            byte[] readBuffer = new byte[4096];
            while (zipInputStream.available() > 0) {
                zipInputStream.read(readBuffer);
            }
            String textFromZipFile = new String(readBuffer);
            assertThat(textFromZipFile).contains(stringFromFile);
        }
    }

    @Test
    void docxFileTest () throws Exception {
        String docxFileName = "170KB.docx";
        File doc = new File(sourcesFolderPath + docxFileName);
        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(doc);
        assertThat(wordMLPackage.name())
                .isEqualTo(docxFileName);
        assertThat(wordMLPackage.getTitle())
                .isEqualTo("Training Plan");
        Set<String> fontSet = wordMLPackage.getMainDocumentPart().fontsInUse();
        assertThat(fontSet.size())
                .isEqualTo(7);
        assertThat(fontSet)
                .contains("Courier New")
                .contains("Symbol")
                .contains("Tahoma")
                .contains("Marlett")
                .contains("Arial")
                .contains("Times New Roman")
                .contains("Wingdings");
    }
}


