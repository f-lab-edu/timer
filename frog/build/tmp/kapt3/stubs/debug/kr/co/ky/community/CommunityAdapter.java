package kr.co.ky.community;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\'B+\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u001c\u0010\u001f\u001a\u00020 2\n\u0010!\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\"\u001a\u00020\u001eH\u0016J\u001c\u0010#\u001a\u00060\u0002R\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001eH\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010\u00a8\u0006("}, d2 = {"Lkr/co/ky/community/CommunityAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lkr/co/ky/community/CommunityAdapter$ViewHolder;", "communityList", "", "Lkr/co/ky/community/CommunityDataClass;", "collection", "", "likeInterface", "Lkr/co/ky/like/LikeInterface;", "cardviewInterface", "Lkr/co/ky/cardviewCollection/CardviewInterface;", "(Ljava/util/List;Ljava/lang/String;Lkr/co/ky/like/LikeInterface;Lkr/co/ky/cardviewCollection/CardviewInterface;)V", "getCardviewInterface", "()Lkr/co/ky/cardviewCollection/CardviewInterface;", "getCollection", "()Ljava/lang/String;", "getCommunityList", "()Ljava/util/List;", "setCommunityList", "(Ljava/util/List;)V", "getLikeInterface", "()Lkr/co/ky/like/LikeInterface;", "option", "Lcom/bumptech/glide/request/RequestOptions;", "getOption", "()Lcom/bumptech/glide/request/RequestOptions;", "uid", "getUid", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "frog_debug"})
public final class CommunityAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<kr.co.ky.community.CommunityAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<kr.co.ky.community.CommunityDataClass> communityList;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String collection = null;
    @org.jetbrains.annotations.NotNull()
    private final kr.co.ky.like.LikeInterface likeInterface = null;
    @org.jetbrains.annotations.NotNull()
    private final kr.co.ky.cardviewCollection.CardviewInterface cardviewInterface = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String uid = null;
    @org.jetbrains.annotations.NotNull()
    private final com.bumptech.glide.request.RequestOptions option = null;
    
    public CommunityAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<kr.co.ky.community.CommunityDataClass> communityList, @org.jetbrains.annotations.NotNull()
    java.lang.String collection, @org.jetbrains.annotations.NotNull()
    kr.co.ky.like.LikeInterface likeInterface, @org.jetbrains.annotations.NotNull()
    kr.co.ky.cardviewCollection.CardviewInterface cardviewInterface) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kr.co.ky.community.CommunityDataClass> getCommunityList() {
        return null;
    }
    
    public final void setCommunityList(@org.jetbrains.annotations.NotNull()
    java.util.List<kr.co.ky.community.CommunityDataClass> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCollection() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.co.ky.like.LikeInterface getLikeInterface() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.co.ky.cardviewCollection.CardviewInterface getCardviewInterface() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getUid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bumptech.glide.request.RequestOptions getOption() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kr.co.ky.community.CommunityAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    kr.co.ky.community.CommunityAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lkr/co/ky/community/CommunityAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lkr/co/ky/kozoltime/databinding/OfficeCardviewBinding;", "(Lkr/co/ky/community/CommunityAdapter;Lkr/co/ky/kozoltime/databinding/OfficeCardviewBinding;)V", "cardView", "Landroidx/cardview/widget/CardView;", "getCardView", "()Landroidx/cardview/widget/CardView;", "likeImage", "Landroid/widget/ImageView;", "getLikeImage", "()Landroid/widget/ImageView;", "bind", "", "title", "", "id", "date", "likeCount", "frog_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final kr.co.ky.kozoltime.databinding.OfficeCardviewBinding binding = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView likeImage = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.cardview.widget.CardView cardView = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        kr.co.ky.kozoltime.databinding.OfficeCardviewBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getLikeImage() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.cardview.widget.CardView getCardView() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.Nullable()
        java.lang.String title, @org.jetbrains.annotations.Nullable()
        java.lang.String id, @org.jetbrains.annotations.Nullable()
        java.lang.String date, @org.jetbrains.annotations.Nullable()
        java.lang.String likeCount) {
        }
    }
}