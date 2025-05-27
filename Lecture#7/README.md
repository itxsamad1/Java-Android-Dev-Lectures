# Lecture #7: RecyclerView and Adapters

## Overview

This lecture focuses on implementing RecyclerView, a more advanced and flexible version of ListView. RecyclerView is designed to display large sets of data efficiently by recycling and reusing view holders, making it more memory-efficient and performant than ListView.

## Topics Covered

### 1. RecyclerView Fundamentals
- Understanding the RecyclerView architecture
- Key components: LayoutManager, Adapter, ViewHolder
- View recycling mechanism
- Performance benefits over ListView

### 2. RecyclerView Components
- **LayoutManager**: Controls layout arrangement
  - LinearLayoutManager (vertical/horizontal)
  - GridLayoutManager
  - StaggeredGridLayoutManager
  
- **Adapter**: Bridge between data and views
  - Creating custom adapters
  - ViewHolder pattern implementation
  - Data binding in adapters
  
- **ViewHolder**: Cache of view references
  - View caching mechanism
  - Efficient view lookup
  - Memory optimization

### 3. Implementation Steps

1. **Add RecyclerView Dependency**
   ```gradle
   implementation 'androidx.recyclerview:recyclerview:1.3.2'
   ```

2. **Add RecyclerView to Layout**
   ```xml
   <androidx.recyclerview.widget.RecyclerView
       android:id="@+id/recyclerView"
       android:layout_width="match_parent"
       android:layout_height="match_parent"/>
   ```

3. **Create ViewHolder Class**
   ```java
   public class MyViewHolder extends RecyclerView.ViewHolder {
       TextView textView;
       
       public MyViewHolder(@NonNull View itemView) {
           super(itemView);
           textView = itemView.findViewById(R.id.text_view);
       }
   }
   ```

4. **Create Custom Adapter**
   ```java
   public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
       private List<String> data;
       
       @NonNull
       @Override
       public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.item_layout, parent, false);
           return new MyViewHolder(view);
       }
       
       @Override
       public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
           holder.textView.setText(data.get(position));
       }
       
       @Override
       public int getItemCount() {
           return data.size();
       }
   }
   ```

5. **Setup RecyclerView in Activity**
   ```java
   RecyclerView recyclerView = findViewById(R.id.recyclerView);
   recyclerView.setLayoutManager(new LinearLayoutManager(this));
   MyAdapter adapter = new MyAdapter(dataList);
   recyclerView.setAdapter(adapter);
   ```

### 4. Advanced Features
- Item decorations for spacing and dividers
- Item animations
- Click listeners for items
- Swipe-to-dismiss functionality
- Drag and drop support

### 5. Best Practices
- Use efficient item layouts
- Implement view holder pattern correctly
- Avoid heavy operations in onBindViewHolder
- Use DiffUtil for efficient updates
- Handle item clicks properly
- Implement pagination when needed

## Sample Code Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── MainActivity.java
│   │   │   ├── adapter/
│   │   │   │   ├── CustomAdapter.java
│   │   │   │   └── CustomViewHolder.java
│   │   │   └── model/
│   │   │       └── DataModel.java
│   │   └── res/
│   │       ├── layout/
│   │       │   ├── activity_main.xml
│   │       │   └── item_layout.xml
│   │       └── values/
│   │           └── strings.xml
└── build.gradle
```

## Common Pitfalls
1. Not using ViewHolder pattern correctly
2. Heavy operations in onBindViewHolder
3. Incorrect layout parameters
4. Not handling item clicks properly
5. Memory leaks in adapters

## Resources
- [Android Developer Documentation - RecyclerView](https://developer.android.com/develop/ui/views/layout/recyclerview)
- [Material Design Guidelines](https://material.io/components/lists)
- [CodeLabs - RecyclerView Fundamentals](https://developer.android.com/codelabs/android-training-create-recycler-view) 