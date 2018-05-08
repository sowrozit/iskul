package com.iskul.services;

import com.iskul.model.Registration;
import org.springframework.stereotype.Repository;

/**
 * Created by Sowrozit on 2/9/2017.
 */
@Repository
public interface RegistrationService {

    public void saveRegistration(Registration registration);
}
