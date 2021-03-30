package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.net.PortUnreachableException;

public class LijnStukTest {
    private Punt punt1 = new Punt(10, 20);
    private Punt zelfdeAlsPunt1 = new Punt(10, 20);
    private Punt punt2 = new Punt(190, 30);
    private Punt zelfdeAlsPunt2 = new Punt(190, 30);

    @Test
    public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() {
        LijnStuk lijnstuk = new LijnStuk(punt1, punt2);

        assertEquals(punt1, lijnstuk.getStartPunt());
        assertEquals(punt2, lijnstuk.getEindPunt());
    }

    @Test(expected = DomainException.class)
    public void LijnStuk_Moet_exception_gooien_als_startpunt_null() {
        new LijnStuk(null, punt2);
    }

    @Test(expected = DomainException.class)
    public void LijnStuk_Moet_exception_gooien_als_eindpunt_null() {
        new LijnStuk(punt1, null);
    }

    @Test
    public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn() {
        LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
        LijnStuk zelfdeLijnStuk = new LijnStuk(zelfdeAlsPunt1, zelfdeAlsPunt2);
        assertTrue(lijnStuk.equals(zelfdeLijnStuk));
    }

    @Test
    public void equals_moet_false_teruggeven_als_parameter_null() {
        LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
        assertFalse(lijnStuk.equals(null));
    }

    @Test(expected = DomainException.class)
    public void LijnStuk_moet_exception_gooien_als_startPunt_gelijk_aan_eindPunt() {
        LijnStuk gelijkePunten = new LijnStuk(punt1, punt1);
    }

    @Test
    public void equals_met_startPunt_gelijk_aan_eindPunt_en_eindPunt_gelijk_aan_startPunt_geeft_true() {
    LijnStuk lijnstuk1 = new LijnStuk(punt1, punt2);
    LijnStuk lijnstuk2 = new LijnStuk(punt2, punt1);
    assertTrue(lijnstuk1.equals(lijnstuk2));
    }

   @Test
    public void getOmhullende_geeftJuiste_waarde()
    {
        Punt p1 = new Punt(100,150);
        Punt p2 = new Punt(200,250);
        LijnStuk l = new LijnStuk(p1,p2);
        Punt p3 = new Punt(100,150);
        Omhullende o = new Omhullende(p3,100,100);
        assertEquals(o,l.getOmhullende());
    }

}
