package com.ramirez.caresoft;

public interface HIPAAComplianceUser {
    abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}

