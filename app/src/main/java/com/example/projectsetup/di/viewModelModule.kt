package com.example.projectsetup.di

import com.example.projectsetup.ui.forgotpassword.code.CodeViewModel
import com.example.projectsetup.ui.forgotpassword.forgotpassword.ForgotPasswordViewModel
import com.example.projectsetup.ui.forgotpassword.resetpassword.ResetPasswordViewModel
import com.example.projectsetup.ui.forgotpassword.resetsuccessful.ResetPasswordSuccessfullModel
import com.example.projectsetup.ui.login.LoginViewModel
import com.example.projectsetup.ui.main.MainViewModel
import com.example.projectsetup.ui.navigation.NavigationViewModel
import com.example.projectsetup.ui.navigation.fragment.account.AccountFragmentViewModel
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.viewModel.AgentOptionsViewModel
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.viewModel.RegisterAgency1ViewModel
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.viewModel.RegisterAgency2ViewModel
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.activity.agent.viewModel.RegisterAgencySuccessViewModel
import com.example.projectsetup.ui.navigation.fragment.account.myProfile.viewModel.*
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.RegisterPropertyRoomViewModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.AgentListViewModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.AgentProfileViewModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.FindAgentByAddressFragmentViewModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.agent.viewModel.FindAgentByAreaFragmentViewModel
import com.example.projectsetup.ui.navigation.fragment.account.registerproperty.register.viewModel.*
import com.example.projectsetup.ui.navigation.fragment.chat.ChatFragmentViewModel
import com.example.projectsetup.ui.navigation.fragment.home.HomeFragmentViewModel
import com.example.projectsetup.ui.navigation.fragment.saved.SavedFragmentViewModel
import com.example.projectsetup.ui.navigation.fragment.saved.all.AllSavedViewModel
import com.example.projectsetup.ui.navigation.fragment.saved.all.AllViewModel
import com.example.projectsetup.ui.navigation.fragment.saved.forrent.ForRentSavedViewModel
import com.example.projectsetup.ui.navigation.fragment.saved.forrent.ForRentViewModel
import com.example.projectsetup.ui.navigation.fragment.saved.forsale.ForSaleSavedViewModel
import com.example.projectsetup.ui.navigation.fragment.saved.forsale.ForSaleViewModel
import com.example.projectsetup.ui.navigation.fragment.saved.savedsearch.SavedSearchSavedViewModel
import com.example.projectsetup.ui.navigation.fragment.saved.savedsearch.SavedSearchViewModel
import com.example.projectsetup.ui.navigation.salehome.SaleHomeActivityViewModel
import com.example.projectsetup.ui.welcome.WelcomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModule: Module = module {

    viewModel { ForgotPasswordViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { RegisterPropertyAddressViewModel() }
    viewModel { RegisterPropertyMapViewModel() }
    viewModel { RegisterPropertyDetailViewModel() }
    viewModel { RegisterPropertyFacilitiesViewModel() }
    viewModel { RegisterPropertyFeatureViewModel() }
    viewModel { CodeViewModel() }
    viewModel { RegisterPropertyWantViewModel() }
    viewModel { RegisterPropertyRelationshipViewModel() }
    viewModel { RegisterPropertyRoomViewModel() }
    viewModel { AgentListViewModel() }
    viewModel { FindAgentByAddressFragmentViewModel() }
    viewModel { FindAgentByAreaFragmentViewModel() }
    viewModel { ResetPasswordSuccessfullModel() }
    viewModel { ResetPasswordViewModel() }
    viewModel { MainViewModel() }
    viewModel { NavigationViewModel() }
    viewModel { ChatFragmentViewModel() }
    viewModel { HomeFragmentViewModel() }
    viewModel { SavedFragmentViewModel() }
    viewModel { ForRentViewModel() }
    viewModel { ForRentSavedViewModel() }
    viewModel { ForSaleViewModel() }
    viewModel { ForSaleSavedViewModel() }
    viewModel { SavedSearchViewModel() }
    viewModel { SavedSearchSavedViewModel() }
    viewModel { WelcomeViewModel() }
    viewModel { RegisterPropertyConditionViewModel() }
    viewModel { RegisterPropertyPhotoViewModel() }
    viewModel { RegisterPropertyDescriptionViewModel() }
    viewModel { RegisterPropertyRentPriceViewModel() }
    viewModel { RegisterPropertySalePriceViewModel() }
    viewModel { RegisterPropertyPreviewViewModel() }
    viewModel { AccountFragmentViewModel() }
    viewModel { RegisterMyPropertyViewModel() }
    viewModel { RegisterPropertyChooseViewModel() }
    viewModel { AgentProfileViewModel() }
    viewModel { AllSavedViewModel() }
    viewModel { AllViewModel() }
    viewModel { SaleHomeActivityViewModel() }
    viewModel { MyProfileViewModel() }
    viewModel { EditProfileViewModel() }
    viewModel { AccountVerificationViewModel() }
    viewModel { IdVerificationViewModel() }
    viewModel { MobileVerificationViewModel() }
    viewModel { EmailVerificationViewModel() }
    viewModel { AgentOptionsViewModel() }
    viewModel { RegisterAgency1ViewModel() }
    viewModel { RegisterAgency2ViewModel() }
    viewModel { RegisterAgencySuccessViewModel() }



}