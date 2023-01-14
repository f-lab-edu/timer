package data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J(\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Ldata/DetailFirebase;", "", "()V", "database", "Lcom/google/firebase/firestore/FirebaseFirestore;", "getDatabase", "()Lcom/google/firebase/firestore/FirebaseFirestore;", "dateformat", "Ljava/text/SimpleDateFormat;", "getDateformat", "()Ljava/text/SimpleDateFormat;", "mutableDetailList", "", "Lkr/co/ky/community/CommunityDataClass$Comment;", "getMutableDetailList", "()Ljava/util/List;", "receiveDetailFirebase", "", "path", "", "document", "detailCallback", "Ldata/DetailListener;", "setDetailview", "commentEditText", "nickname", "page", "documentFromAdapter", "frog_debug"})
public final class DetailFirebase {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kr.co.ky.community.CommunityDataClass.Comment> mutableDetailList = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore database = null;
    @org.jetbrains.annotations.NotNull()
    private final java.text.SimpleDateFormat dateformat = null;
    
    public DetailFirebase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kr.co.ky.community.CommunityDataClass.Comment> getMutableDetailList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.firestore.FirebaseFirestore getDatabase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.text.SimpleDateFormat getDateformat() {
        return null;
    }
    
    public final void receiveDetailFirebase(@org.jetbrains.annotations.NotNull()
    java.lang.String path, @org.jetbrains.annotations.NotNull()
    java.lang.String document, @org.jetbrains.annotations.NotNull()
    data.DetailListener detailCallback) {
    }
    
    public final void setDetailview(@org.jetbrains.annotations.Nullable()
    java.lang.String commentEditText, @org.jetbrains.annotations.NotNull()
    java.lang.String nickname, @org.jetbrains.annotations.NotNull()
    java.lang.String page, @org.jetbrains.annotations.NotNull()
    java.lang.String documentFromAdapter) {
    }
}