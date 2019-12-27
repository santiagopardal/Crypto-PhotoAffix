package com.example.cripto_photoaffix.Visitors;

import com.example.cripto_photoaffix.Activities.LoginActivity;

public class FingerprintUnsuccessfulAuthenticationVisitor implements Visitor {

    @Override
    public void visit(LoginActivity activity) {
        activity.loginUnsuccessful();
    }
}
