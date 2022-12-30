package kr.co.ky.detail;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lkr/co/ky/detail/DetailAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lkr/co/ky/detail/DetailAdapter$ViewHolder;", "detailChatList", "", "Lkr/co/ky/community/CommunityDataClass$Comment;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "frog_debug"})
public final class DetailAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<kr.co.ky.detail.DetailAdapter.ViewHolder> {
    private final java.util.List<kr.co.ky.community.CommunityDataClass.Comment> detailChatList = null;
    
    public DetailAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<kr.co.ky.community.CommunityDataClass.Comment> detailChatList) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kr.co.ky.detail.DetailAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    kr.co.ky.detail.DetailAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lkr/co/ky/detail/DetailAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lkr/co/ky/kozoltime/databinding/DetailCardviewBinding;", "(Lkr/co/ky/kozoltime/databinding/DetailCardviewBinding;)V", "getBinding", "()Lkr/co/ky/kozoltime/databinding/DetailCardviewBinding;", "bind", "", "nickname", "", "date", "context", "frog_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final kr.co.ky.kozoltime.databinding.DetailCardviewBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        kr.co.ky.kozoltime.databinding.DetailCardviewBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kr.co.ky.kozoltime.databinding.DetailCardviewBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.Nullable()
        java.lang.String nickname, @org.jetbrains.annotations.Nullable()
        java.lang.String date, @org.jetbrains.annotations.Nullable()
        java.lang.String context) {
        }
    }
}