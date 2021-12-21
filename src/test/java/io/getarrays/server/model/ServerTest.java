package io.getarrays.server.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.getarrays.server.enumeration.Status;
import org.junit.jupiter.api.Test;

class ServerTest {
    @Test
    void testCanEqual() {
        assertFalse((new Server()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        Server server = new Server();

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertTrue(server.canEqual(server1));
    }

    @Test
    void testConstructor() {
        Server actualServer = new Server();
        actualServer.setId(123L);
        actualServer.setImageUrl("https://example.org/example");
        actualServer.setIpAddress("42 Main St");
        actualServer.setMemory("Memory");
        actualServer.setName("Name");
        actualServer.setStatus(Status.SERVER_UP);
        actualServer.setType("Type");
        assertEquals(123L, actualServer.getId().longValue());
        assertEquals("https://example.org/example", actualServer.getImageUrl());
        assertEquals("42 Main St", actualServer.getIpAddress());
        assertEquals("Memory", actualServer.getMemory());
        assertEquals("Name", actualServer.getName());
        assertEquals(Status.SERVER_UP, actualServer.getStatus());
        assertEquals("Type", actualServer.getType());
        assertEquals(
                "Server(id=123, ipAddress=42 Main St, name=Name, memory=Memory, type=Type, imageUrl=https://example.org"
                        + "/example, status=SERVER_UP)",
                actualServer.toString());
    }

    @Test
    void testConstructor2() {
        Server actualServer = new Server(123L, "42 Main St", "Name", "Memory", "Type", "https://example.org/example",
                Status.SERVER_UP);
        actualServer.setId(123L);
        actualServer.setImageUrl("https://example.org/example");
        actualServer.setIpAddress("42 Main St");
        actualServer.setMemory("Memory");
        actualServer.setName("Name");
        actualServer.setStatus(Status.SERVER_UP);
        actualServer.setType("Type");
        assertEquals(123L, actualServer.getId().longValue());
        assertEquals("https://example.org/example", actualServer.getImageUrl());
        assertEquals("42 Main St", actualServer.getIpAddress());
        assertEquals("Memory", actualServer.getMemory());
        assertEquals("Name", actualServer.getName());
        assertEquals(Status.SERVER_UP, actualServer.getStatus());
        assertEquals("Type", actualServer.getType());
        assertEquals(
                "Server(id=123, ipAddress=42 Main St, name=Name, memory=Memory, type=Type, imageUrl=https://example.org"
                        + "/example, status=SERVER_UP)",
                actualServer.toString());
    }

    @Test
    void testEquals() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");
        assertFalse(server.equals(null));
    }

    @Test
    void testEquals2() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");
        assertFalse(server.equals("Different type to Server"));
    }

    @Test
    void testEquals3() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");
        assertTrue(server.equals(server));
        int expectedHashCodeResult = server.hashCode();
        assertEquals(expectedHashCodeResult, server.hashCode());
    }

    @Test
    void testEquals4() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertTrue(server.equals(server1));
        int expectedHashCodeResult = server.hashCode();
        assertEquals(expectedHashCodeResult, server1.hashCode());
    }

    @Test
    void testEquals5() {
        Server server = new Server();
        server.setId(0L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals6() {
        Server server = new Server();
        server.setId(null);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals7() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("42 Main St");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals8() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl(null);
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals9() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("Name");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals10() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress(null);
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals11() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("42 Main St");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals12() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory(null);
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals13() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("42 Main St");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals14() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName(null);
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals15() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(null);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals16() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_DOWN);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals17() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("42 Main St");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals18() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType(null);

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertFalse(server.equals(server1));
    }

    @Test
    void testEquals19() {
        Server server = new Server();
        server.setId(null);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(null);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertTrue(server.equals(server1));
        int expectedHashCodeResult = server.hashCode();
        assertEquals(expectedHashCodeResult, server1.hashCode());
    }

    @Test
    void testEquals20() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl(null);
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl(null);
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertTrue(server.equals(server1));
        int expectedHashCodeResult = server.hashCode();
        assertEquals(expectedHashCodeResult, server1.hashCode());
    }

    @Test
    void testEquals21() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress(null);
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress(null);
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertTrue(server.equals(server1));
        int expectedHashCodeResult = server.hashCode();
        assertEquals(expectedHashCodeResult, server1.hashCode());
    }
}

