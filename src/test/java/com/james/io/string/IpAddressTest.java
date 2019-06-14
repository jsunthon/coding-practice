package com.james.io.string;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class IpAddressTest {

    @Test
    public void genValidAddresses() {
        String ip = "19216811";

        List<String> ipAddresses = IpAddress.genValidAddresses(ip);

        assertTrue(ipAddresses.contains("192.168.1.1"));
        assertTrue(ipAddresses.contains("192.16.81.1"));
        assertTrue(ipAddresses.contains("19.216.81.1"));
    }
}