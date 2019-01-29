import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

public class Test {
    private static final DateTimeFormatter dtf = DateTimeFormatter
            .ofPattern("yyyy/MM/dd HH:mm:ss");

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        System.out.println("Make User Properties");
//        User_Info info = new User_Info();
//        info.setEachInfo(Info.EMAIL, "mmmm@gmail.com");
//        info.setEachInfo(Info.PHONENO, "123455");
//        System.out.println(info.print());
        System.out.println("Make user ");
        int user_counter = 0;
        User user = new User("mamad", "qwerty");
        User user1 = new User("amir", "qwerty");
        user.insertUser(user);

        System.out.println("Two Users are Created.");


        System.out.println("Make Hotel Properties");
        System.out.println("Make Coordination Properties");
        Coordination coordination = new Coordination(125.256,-180.365);
        System.out.println("Make Price Properties");
        Price price = new Price(100, Currency.DOLLOR);
        System.out.println("Make Room Properties");
        Room room1 = new Room("nilofar", RoomType.DELUX, RoomStatus.AVAILABLE, 2, price,"lorem epsum", "","" );
        Room room2 = new Room("samira", RoomType.HONEYMOON, RoomStatus.SOLDOUT, 2, price,"lorem epsum", "","" );

        System.out.println("Make Room_List Properties");
        Room_List room_list = new Room_List();
        room_list.addRoom(room1);
        room_list.addRoom(room2);


        Hotel hotel = new Hotel("Espinas", 5, coordination, price,"lorem epsum", "",false,"", room_list );



        System.out.println("make comments for hotel");
        Comment comment1 = new Comment(user1, "good");
        Comment comment2 = new Comment(user1, "great!");
        Comment_List commentList = hotel.getCommentList();
        commentList.addComment(comment1);
        commentList.addComment(comment2);
        //System.out.println(commentList.getCommentList());
        System.out.println("Hotel's comments content:");
        for (Comment comm : commentList.getCommentList()) {
            System.out.println(comm.getContent());
        }
















//        System.out.println("Make Post Properties");
//        HashMap<String, String> props = new HashMap<>();
//        props.put("category", Locale.Category.TRADITIONAL.toString());
//        props.put("cookTime", "70");
//        System.out.println("Make Ingredient list ");
//        Ingredient_List ingList = new Ingredient_List();
//        Ingredient ing = new Ingredient("sugar", 100, "gr");
//        Ingredient ing1 = new Ingredient("salt", 200, "gr");
//        ingList.addIngredient(ing);
//        ingList.addIngredient(ing1);
//        props.put("ingredientList", Integer.toString(ingList.getId()));
//
//        System.out.println("Make user info ");
//        User_Info info = new User_Info();
//        info.setEachInfo(Info.EMAIL, "taghavi@gmail.com");
//        info.setEachInfo(Info.PHONENO, "123455");
//        System.out.println("Make user ");
//        User user = new User("amir", "qwerty", info);
//        User user1 = new User("erfan", "qwerty", info);
//
//        System.out.println("Make posts");
//        LocalDateTime now = LocalDateTime.now();
//        String date = dtf.format(now);
//        String desc = "new foood!!";
//        Post post = new Post(user, "baking", date, Post_Type.RECIPE, desc,
//                props);
//        Post post1 = new Post(user, "cooking", date, Post_Type.RECIPE, desc,
//                props);
//        post.setProperty("difficulty", Difficulty.MEDIUM.toString());
//        System.out.println("post properties:");
//        System.out.println(post.getProperties());
//        System.out.println("post1 properties:");
//        System.out.println(post1.getProperties());
//
//        System.out.println("make post inventory");
//        Post_Inventory inventory = new Post_Inventory();
//        inventory.addPost(post);
//        inventory.addPost(post1);
//
//        System.out.println("user posts:");
//        System.out.println(inventory.getUserPosts(user));
//
//
//
//        System.out.println("user and user1 likes post");
//        Likes postLikes = post.getLikes();
//        postLikes.like(user1);
//        postLikes.like(user);
//        System.out.println("post likers:");
//        System.out.println(postLikes.getLikers());
//        System.out.println("user unlike post");
//        postLikes.unlike(user);
//        System.out.println("post likers:");
//        System.out.println(postLikes.getLikers());
//
//        System.out.println("user save post and post1");
//        Saved_Posts userSavedPost = user.getSavedPosts();
//        userSavedPost.addPost(post);
//        userSavedPost.addPost(post1);
//        //userSavedPost.delPost(post1.getId());
//        System.out.println("user's saved posts title:");
//        for (Post post2 : user.getSavedPosts().getSavedPosts()) {
//            System.out.println(post2.getTitle());
//        }
//
    }
}
