package kr.co.ky.community;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J-\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u000e\u0010#\u001a\n\u0012\u0006\b\u0001\u0012\u00020%0$2\u0006\u0010&\u001a\u00020\'H\u0016\u00a2\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006*"}, d2 = {"Lkr/co/ky/community/CommunityWriteActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lkr/co/ky/kozoltime/databinding/WriteCommunityActivityBinding;", "dateformat", "Ljava/text/SimpleDateFormat;", "fbAuth", "Lcom/google/firebase/auth/FirebaseAuth;", "fbFirestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "firebaseUri", "Landroid/net/Uri;", "getFirebaseUri", "()Landroid/net/Uri;", "setFirebaseUri", "(Landroid/net/Uri;)V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "storage", "Lcom/google/firebase/storage/FirebaseStorage;", "SettingPopup", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "showPermissionContextPopup", "frog_debug"})
public final class CommunityWriteActivity extends androidx.appcompat.app.AppCompatActivity {
    private kr.co.ky.kozoltime.databinding.WriteCommunityActivityBinding binding;
    private final com.google.firebase.auth.FirebaseAuth fbAuth = null;
    private final com.google.firebase.firestore.FirebaseFirestore fbFirestore = null;
    private final com.google.firebase.storage.FirebaseStorage storage = null;
    private final java.text.SimpleDateFormat dateformat = null;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri firebaseUri;
    @org.jetbrains.annotations.NotNull()
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> launcher;
    
    public CommunityWriteActivity() {
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
    
    private final void showPermissionContextPopup() {
    }
    
    private final void SettingPopup() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
}