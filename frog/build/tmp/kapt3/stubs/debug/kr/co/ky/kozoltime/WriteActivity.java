package kr.co.ky.kozoltime;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J-\u0010\'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\u000e\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060+2\u0006\u0010,\u001a\u00020-H\u0016\u00a2\u0006\u0002\u0010.J\u0006\u0010/\u001a\u00020$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R(\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u00190\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\b\"\u0004\b!\u0010\"\u00a8\u00060"}, d2 = {"Lkr/co/ky/kozoltime/WriteActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lkr/co/ky/kozoltime/databinding/ActivityWriteBinding;", "collection", "", "getCollection", "()Ljava/lang/String;", "dateformat", "Ljava/text/SimpleDateFormat;", "getDateformat", "()Ljava/text/SimpleDateFormat;", "fbAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "fbFirestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "firebaseUri", "Landroid/net/Uri;", "getFirebaseUri", "()Landroid/net/Uri;", "setFirebaseUri", "(Landroid/net/Uri;)V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "writeSpinner", "getWriteSpinner", "setWriteSpinner", "(Ljava/lang/String;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "showPermissionContextPopup", "frog_debug"})
public final class WriteActivity extends androidx.appcompat.app.AppCompatActivity {
    private kr.co.ky.kozoltime.databinding.ActivityWriteBinding binding;
    private final com.google.firebase.auth.FirebaseAuth fbAuth = null;
    private final com.google.firebase.firestore.FirebaseFirestore fbFirestore = null;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri firebaseUri;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String collection = "office";
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dateformat = null;
    public java.lang.String writeSpinner;
    @org.jetbrains.annotations.NotNull()
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> launcher;
    
    public WriteActivity() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri getFirebaseUri() {
        return null;
    }
    
    public final void setFirebaseUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCollection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.text.SimpleDateFormat getDateformat() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWriteSpinner() {
        return null;
    }
    
    public final void setWriteSpinner(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getLauncher() {
        return null;
    }
    
    public final void setLauncher(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<android.content.Intent> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void showPermissionContextPopup() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
}