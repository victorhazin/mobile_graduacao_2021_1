package com.cesarschool.helloword

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_estado.view.*

class EstadoAdapter (private val context:Context,
                     private val estados:List<Estado>) : BaseAdapter(){

//    private val bandeiras: TypedArray by lazy()

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * [android.view.LayoutInflater.inflate]
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position The position of the item within the adapter's data set of the item whose view
     * we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     * is non-null and of an appropriate type before using. If it is not possible to convert
     * this view to display the correct data, this method can create a new view.
     * Heterogeneous lists can specify their number of view types, so that this View is
     * always of the right type (see [.getViewTypeCount] and
     * [.getItemViewType]).
     * @param parent The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        val estado = estados[position]
        val linha:View
        val holder:ViewHolder

        if(view == null){
            linha = LayoutInflater.from(context).inflate(R.layout.item_estado, parent, false)
            holder = ViewHolder(linha)
            linha.tag = holder
        }else{
            linha = view
            holder = view.tag as ViewHolder
        }

        holder.txtName.text = estado.nome
//        holder.imgBandeira.setImageDrawable(bandeiras.getDra)

        return linha;
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     * data set.
     * @return The data at the specified position.
     */
    override fun getItem(position: Int) = estados[position]

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    override fun getItemId(position: Int) = position.toLong()

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    override fun getCount() = estados.size

    companion object{
        data class ViewHolder(val view:View){
            val imgBandeira: ImageView = view.imageViewFlag
            val txtName: TextView = view.textViewEstadoNome
        }
    }

}