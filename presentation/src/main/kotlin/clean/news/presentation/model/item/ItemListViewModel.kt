package clean.news.presentation.model.item

import clean.news.app.usecase.item.GetAskStories
import clean.news.app.usecase.item.GetJobStories
import clean.news.app.usecase.item.GetNewStories
import clean.news.app.usecase.item.GetShowStories
import clean.news.app.usecase.item.GetTopStories
import clean.news.core.entity.Item
import clean.news.presentation.navigation.NavigationFactory
import clean.news.presentation.navigation.NavigationService
import javax.inject.Inject

class ItemListViewModel @Inject constructor(
		private val navigationService: NavigationService,
		private val navigationFactory: NavigationFactory,
		private val listType: Item.ListType,
		private val getTopStories: GetTopStories,
		private val getNewStories: GetNewStories,
		private val getShowStories: GetShowStories,
		private val getAskStories: GetAskStories,
		private val getJobStories: GetJobStories) {

	val items = when (listType) {
		Item.ListType.TOP -> getTopStories.execute()
		Item.ListType.NEW -> getNewStories.execute()
		Item.ListType.SHOW -> getShowStories.execute()
		Item.ListType.ASK -> getAskStories.execute()
		Item.ListType.JOBS -> getJobStories.execute()
	}
}