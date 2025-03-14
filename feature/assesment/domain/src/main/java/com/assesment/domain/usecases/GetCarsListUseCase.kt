package com.assesment.domain.usecases
import com.assesment.domain.repo.RepoInterface
import com.core.common.component.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCarsListUseCase @Inject constructor(private val repoInterface: RepoInterface) {
    operator  fun invoke()= flow {
        emit(UiEvent.Loading())
         emit(UiEvent.Success(repoInterface.getCarsList()))
    }.catch {
        emit(UiEvent.Error())

    }.flowOn(Dispatchers.IO)
}