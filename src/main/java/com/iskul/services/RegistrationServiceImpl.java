package com.iskul.services;

import com.iskul.dao.RegistrationDao;
import com.iskul.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Sowrozit on 2/9/2017.
 */

@Service("registrationService")
@Repository
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationDao registrationDao;

    public void setRegistrationDao(RegistrationDao registrationDao)
    {
        this.registrationDao=registrationDao;
    }
    @Override
    public void saveRegistration(Registration registration) {

        registrationDao.saveRegistration(registration);

    }
}
