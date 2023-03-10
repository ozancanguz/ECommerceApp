package com.ozancanguz.e_commerceapp.data

import com.ozancanguz.e_commerceapp.data.localdatasource.LocalDataSource
import com.ozancanguz.e_commerceapp.data.remotedatasource.RemoteDataSource
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository@Inject constructor(remoteDataSource: RemoteDataSource,
             localDataSource: LocalDataSource
                                    ) {

    val remote=remoteDataSource
    val local=localDataSource

}