import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task_app.databinding.RecyclerItemBinding

class RecyclerAdapter(private val data: ArrayList<Array<String?>>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    // ViewHolder Class to bind the views
    inner class ViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Array<String?>) {
            binding.itemName.text = "Name: ${item[0]}"
            binding.itemEmail.text = "Email: ${item[1]}"
            binding.itemGender.text = "Gender: ${item[2]}"
            binding.itemCountry.text = "Country: ${item[3]}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = data.size
}
