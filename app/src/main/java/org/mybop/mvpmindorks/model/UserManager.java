package org.mybop.mvpmindorks.model;

import org.mybop.mvpmindorks.login.LoginContract;
import org.mybop.mvpmindorks.main.MainContract;
import org.mybop.mvpmindorks.splash.SplashContract;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Single;

@Singleton
public class UserManager implements SplashContract.Model, LoginContract.Model, MainContract.Model {

    private SharedPrefsHelper sharedPrefsHelper;

    @Inject
    UserManager(SharedPrefsHelper sharedPrefsHelper) {
        this.sharedPrefsHelper = sharedPrefsHelper;
    }

    @Override
    public Completable clear() {
        return Completable.fromAction(() -> sharedPrefsHelper.clear());
    }

    @Override
    public Completable saveEmail(final String email) {
        return Completable.fromAction(() -> sharedPrefsHelper.putEmail(email));
    }

    @Override
    public Single<String> getEmail() {
        return Single.fromCallable(() -> sharedPrefsHelper.getEmail());
    }

    @Override

    public Completable setLoggedIn() {
        return Completable.fromAction(() -> sharedPrefsHelper.setLoggedIn());
    }

    @Override
    public Single<Boolean> getLoggedInMode() {
        return Single.fromCallable(() -> sharedPrefsHelper.getLoggedInMode());
    }
}
