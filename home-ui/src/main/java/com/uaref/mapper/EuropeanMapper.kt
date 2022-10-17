package com.uaref.mapper

import com.maxshop.model.RecyclerItem
import com.uaref.home_ui.BR
import com.uaref.home_ui.R
import com.uaref.model.European
import com.uaref.viewState.EuropeanViewState

internal class EuropeanMapper {
    fun toViewState(european: European) = EuropeanViewState(
        european.id,
        european.imageURL,
        european.name,
        european.description
    )

    fun toRecyclerItem(europeanViewState: EuropeanViewState) = RecyclerItem(
        europeanViewState,
        R.layout.item_european_home_tab,
        BR.human
    )
}
