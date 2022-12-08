package kr.co.ky.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0006\u0010\u0018\u001a\u00020\u0014J\u0006\u0010\u0019\u001a\u00020\u0014J\u0010\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0006\u0010 \u001a\u00020\u0014J\u0006\u0010!\u001a\u00020\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lkr/co/ky/login/LoginJoinActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "setAuth", "(Lcom/google/firebase/auth/FirebaseAuth;)V", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "setGoogleSignInClient", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;)V", "startForResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "detectEmailAndPasswordEmpty", "", "firebaseAuthWithGoogle", "account", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "googleLogin", "guestMoveMainPage", "moveMainPage", "user", "Lcom/google/firebase/auth/FirebaseUser;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "signinAndSignup", "signinEmail", "frog_debug"})
public final class LoginJoinActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private com.google.firebase.auth.FirebaseAuth auth;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.gms.auth.api.signin.GoogleSignInClient googleSignInClient;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> startForResult = null;
    private java.util.HashMap _$_findViewCache;
    
    public LoginJoinActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getAuth() {
        return null;
    }
    
    public final void setAuth(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.auth.api.signin.GoogleSignInClient getGoogleSignInClient() {
        return null;
    }
    
    public final void setGoogleSignInClient(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.auth.api.signin.GoogleSignInClient p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void googleLogin() {
    }
    
    public final void firebaseAuthWithGoogle(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.auth.api.signin.GoogleSignInAccount account) {
    }
    
    public final void signinAndSignup() {
    }
    
    public final void signinEmail() {
    }
    
    public final void moveMainPage(@org.jetbrains.annotations.Nullable()
    com.google.firebase.auth.FirebaseUser user) {
    }
    
    public final void guestMoveMainPage() {
    }
    
    private final void detectEmailAndPasswordEmpty() {
    }
}