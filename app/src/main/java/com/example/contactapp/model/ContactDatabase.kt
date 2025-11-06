import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactapp.model.Contact
import com.example.contactapp.model.ContactDao

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase(){
    abstract fun contactDao() : ContactDao

    companion object{
        @Volatile
        private var INSTANCE : ContactDatabase? = null
        fun gatDatabase(context : Context) : ContactDatabase {
            synchronized(this){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDatabase::class.java,
                        "contactDB").build()
                }
            }
            return INSTANCE!!
        }
    }
}