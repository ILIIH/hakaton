package com.uaref.mapper

import com.maxshop.model.RecyclerItem
import com.uaref.home_ui.BR
import com.uaref.home_ui.R
import com.uaref.model.Ukrainian
import com.uaref.viewState.UkrainianViewState

internal class UkrainianMapper {
    fun toViewState(ukrainian: Ukrainian) = UkrainianViewState(
        ukrainian.id,
        ukrainian.imageURL,
        ukrainian.name,
        ukrainian.description
    )

    fun toRecyclerItem(ukrainianViewState: UkrainianViewState) = RecyclerItem(
        ukrainianViewState,
        R.layout.item_ukranian_home_tab,
        BR.human
    )
}
