package io.getarrays.server.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.getarrays.server.enumeration.Status;
import io.getarrays.server.model.Server;
import io.getarrays.server.repo.ServerRepo;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ServerServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ServerServiceImplTest {
    @MockBean
    private ServerRepo serverRepo;

    @Autowired
    private ServerServiceImpl serverServiceImpl;

    @Test
    void testPing() throws IOException {
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
        when(this.serverRepo.save((Server) any())).thenReturn(server1);
        when(this.serverRepo.findByIpAddress((String) any())).thenReturn(server);
        Server actualPingResult = this.serverServiceImpl.ping("42");
        assertSame(server, actualPingResult);
        assertEquals(Status.SERVER_DOWN, actualPingResult.getStatus());
        verify(this.serverRepo).findByIpAddress((String) any());
        verify(this.serverRepo).save((Server) any());
    }

    @Test
    void testPing2() throws IOException {
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
        when(this.serverRepo.save((Server) any())).thenReturn(server1);
        when(this.serverRepo.findByIpAddress((String) any())).thenReturn(server);
        Server actualPingResult = this.serverServiceImpl.ping("");
        assertSame(server, actualPingResult);
        assertEquals(Status.SERVER_UP, actualPingResult.getStatus());
        verify(this.serverRepo).findByIpAddress((String) any());
        verify(this.serverRepo).save((Server) any());
    }

    @Test
    void testList() {
        when(this.serverRepo.findAll((org.springframework.data.domain.Pageable) any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        assertTrue(this.serverServiceImpl.List(1).isEmpty());
        verify(this.serverRepo).findAll((org.springframework.data.domain.Pageable) any());
    }

    @Test
    void testGet() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");
        Optional<Server> ofResult = Optional.of(server);
        when(this.serverRepo.findById((Long) any())).thenReturn(ofResult);
        assertSame(server, this.serverServiceImpl.get(123L));
        verify(this.serverRepo).findById((Long) any());
    }

    @Test
    void testUpdate() {
        Server server = new Server();
        server.setId(123L);
        server.setImageUrl("https://example.org/example");
        server.setIpAddress("42 Main St");
        server.setMemory("Memory");
        server.setName("Name");
        server.setStatus(Status.SERVER_UP);
        server.setType("Type");
        when(this.serverRepo.save((Server) any())).thenReturn(server);

        Server server1 = new Server();
        server1.setId(123L);
        server1.setImageUrl("https://example.org/example");
        server1.setIpAddress("42 Main St");
        server1.setMemory("Memory");
        server1.setName("Name");
        server1.setStatus(Status.SERVER_UP);
        server1.setType("Type");
        assertSame(server, this.serverServiceImpl.update(server1));
        verify(this.serverRepo).save((Server) any());
    }

    @Test
    void testDelete() {
        doNothing().when(this.serverRepo).deleteById((Long) any());
        assertTrue(this.serverServiceImpl.delete(123L));
        verify(this.serverRepo).deleteById((Long) any());
    }
}

