package bahavioral;


import static org.junit.jupiter.api.Assertions.assertEquals;


import com.fahad.behavioral.template.Computer;
import com.fahad.behavioral.template.HighEndComputerBuilder;
import com.fahad.behavioral.template.StandardComputerBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;


public class TemplateMethodPatternIntegrationTest {

    private static StandardComputerBuilder standardComputerBuilder;
    private static HighEndComputerBuilder highEndComputerBuilder;

    @BeforeAll
    public static void setUpStandardComputerBuilderInstance() {
        standardComputerBuilder = new StandardComputerBuilder();
    }

    @BeforeAll
    public static void setUpHighEndComputerBuilderInstance() {
        highEndComputerBuilder = new HighEndComputerBuilder();
    }

    @Test
    public void givenStandardMotherBoard_whenAddingMotherBoard_thenEqualAssertion() {
        standardComputerBuilder.addMotherboard();
        assertEquals("Standard Motherboard", standardComputerBuilder.getComputerParts().get("Motherboard"));
    }

    @Test
    public void givenStandardMotherboard_whenSetup_thenTwoEqualAssertions() {
        standardComputerBuilder.setupMotherboard();
        assertEquals("Screwing the standard motherboard to the case.", standardComputerBuilder.getMotherboardSetupStatus().get(0));
        assertEquals("Pluging in the power supply connectors.", standardComputerBuilder.getMotherboardSetupStatus().get(1));
    }

    @Test
    public void givenStandardProcessor_whenAddingProcessor_thenEqualAssertion() {
        standardComputerBuilder.addProcessor();
        assertEquals("Standard Processor", standardComputerBuilder.getComputerParts().get("Processor"));
    }

    @Test
    public void givenAllStandardParts_whenBuildingComputer_thenTwoParts() {
        standardComputerBuilder.buildComputer();
        assertEquals(2, standardComputerBuilder.getComputerParts().size());
    }

    @Test
    public void givenAllStandardParts_whenComputerisBuilt_thenComputerInstance() {
        //assertThat(standardComputerBuilder.buildComputer(), instanceOf(Computer.class));
        Assertions.assertInstanceOf(Computer.class,standardComputerBuilder.buildComputer());

    }

    @Test
    public void givenHighEnddMotherBoard_whenAddingMotherBoard_thenEqualAssertion() {
        highEndComputerBuilder.addMotherboard();
        assertEquals("High-end Motherboard", highEndComputerBuilder.getComputerParts().get("Motherboard"));
    }

    @Test
    public void givenHighEnddMotheroboard_whenSetup_thenTwoEqualAssertions() {
        highEndComputerBuilder.setupMotherboard();
        assertEquals("Screwing the high-end motherboard to the case.", highEndComputerBuilder.getMotherboardSetupStatus().get(0));
        assertEquals("Pluging in the power supply connectors.", highEndComputerBuilder.getMotherboardSetupStatus().get(1));
    }

    @Test
    public void givenHightEndProcessor_whenAddingProcessor_thenEqualAssertion() {
        highEndComputerBuilder.addProcessor();
        assertEquals("High-end Processor", highEndComputerBuilder.getComputerParts().get("Processor"));
    }

    @Test
    public void givenAllHighEnddParts_whenBuildingComputer_thenTwoParts() {
        highEndComputerBuilder.buildComputer();
        assertEquals(2, highEndComputerBuilder.getComputerParts().size());
    }

    @Test
    public void givenAllHighEndParts_whenComputerisBuilt_thenComputerInstance() {
        //assertThat(standardComputerBuilder.buildComputer(), instanceOf(Computer.class));
        Assertions.assertInstanceOf(Computer.class,standardComputerBuilder.buildComputer());
    }
}