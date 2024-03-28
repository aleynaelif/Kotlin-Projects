package com.leys.compose

import Notification
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBarDefaults.containerColor
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leys.compose.ui.theme.Beige
import com.leys.compose.ui.theme.ComposeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    //LearnTextAndModifiers()
                    //LearnRowColumBox()
                    //LearnAlignmentArrangement()
                    //LearnButton()
                    //LearnImage()
                    //LearnState()
                    //LearnTopAppBar()
                    //LearnNavDrawer()
                    MyBottomAppBar()
                }
            }
        }
    }
}
@Composable
fun LearnTextAndModifiers(){

    val clickOnText = {}

    Text(text = stringResource(R.string.hello_text),
        color = Color.Magenta,
        fontSize = 32.sp,
        fontStyle = FontStyle.Italic,
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Yellow)
            .clickable(onClick = clickOnText)
    )
}

@Preview(showBackground = true)
@Composable
fun LearnTextAndModifiersPreview() {
    ComposeTheme {
        LearnTextAndModifiers()
    }
}

@Composable
fun LearnRowColumBox(){

    // Overlap
    Text(text = "Hello Column")
    Text(text = "Hello Row")
    Text(text = "Hello Box")


    //Column Layout
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "Hello Column 1")
        Text(text = "Hello Column 2")
        Text(text = "Hello Column 3")
    }


    //Row Layout
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Hello Row 1")
        Text(text = "Hello Row 2")
        Text(text = "Hello Row 3")
    }


    //Box Layout
    Box (modifier = Modifier
        .fillMaxSize()
        .background(Color.Magenta), contentAlignment = Alignment.Center){
        Box (modifier = Modifier
            .height(300.dp)
            .width(300.dp)
            .background(Color.Blue)){
            Text(text = "Hello Box 1",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                fontSize = 32.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LearnRowColumBoxPreview() {
    ComposeTheme {
        LearnRowColumBox()
    }
}

//Alignment = Cross Axis (Row = Vertical, Column = Horizontal)
//Arrangement = Main Axis (Row = Horizontal, Column = Vertical)

@Composable
fun LearnAlignmentArrangement(){
    //RowAlignment: Top, CenterVertically, Bottom
    //ColumnAlignment: Start, CenterHorizontally, End, SpaceBetween, SpaceAround, SpaceEvenly
    //Absolute.Left, Absolute.Center, Absolute.Right
    //Absolute.SpaceBetween, Absolute.SpaceAround, Absolute.SpaceEvenly
    
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Text(text = "Row Alignment Arrangement")
    }

    //ColumnAlignment: Start, CenterHorizontally, End
    //ColumnArrangement: Top, Center, Bottom, SpaceBetween, SpaceAround, SpaceEvenly

    Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {
        Text(text = "Column Alignment Arrangement")
    }

    //BoxAlignment = TopStart, TopCenter, TopEnd, CenterStart, Center, CenterEnd, BottomStart, BottomCenter, BottomEnd

    Box (contentAlignment = Alignment.BottomCenter){
        Text(text = "Box Alignment", modifier = Modifier.align(Alignment.Center))
        // Modifierla başka bir alignment belirtirsek program onu takip eder. Bottom center yerine centerı çalıştırır.
    }
}

@Preview(showBackground = true)
@Composable
fun LearnAlignmentArrangementPreview() {
    ComposeTheme {
        LearnAlignmentArrangement()
    }
}

@Composable
fun LearnButton(){
    val context =LocalContext.current.applicationContext
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show() },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta)
        ) {
            Text(text = "Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LearnButtonPreview() {
    ComposeTheme {
        LearnButton()
    }
}

@Composable
fun LearnImage(){
    Image(painter = painterResource(id = R.drawable.sun), contentDescription = "Sun")
}

@Preview(showBackground = true)
@Composable
fun LearnImagePreview() {
    ComposeTheme {
        LearnImage()
    }
}

@Composable
fun LearnState(){

    //var age = 0

    var age by remember {
        mutableIntStateOf(0)
    }

    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { age++ }) {
            Text(text = "Age: $age")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun LearnStatePreview() {
    ComposeTheme {
        LearnState()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnTopAppBar(){
    /*
        top barın gözükmesi için kod şöyle olmalı:
        Surface(
                    //modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
     */

    val context = LocalContext.current.applicationContext

    TopAppBar(title = { Text(text = "Arcana") },
        navigationIcon = {
            IconButton(onClick = { Toast.makeText(context, "Arcana", Toast.LENGTH_SHORT).show() }) {
                Icon(painter = painterResource(id = R.drawable.tarot), contentDescription = "Tarot icon")
            }
        }, colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Beige,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.Black
        ), actions = {
            IconButton(onClick = { Toast.makeText(context, "Profile", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile icon", tint = Color.Black)
            }
            IconButton(onClick = { Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search icon", tint = Color.Black)
            }
            IconButton(onClick = { Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show() }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu icon", tint = Color.Black)
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun LearnTopAppBarPreview() {
    ComposeTheme {
        LearnTopAppBar()
        }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnNavDrawer(){
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(modifier = Modifier
                    .background(Beige)
                    .fillMaxWidth()
                    .height(150.dp)) {
                    Text(text = "Arcana", modifier = Modifier.align(Alignment.Center))
                }
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Home") },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Home, contentDescription = "Home") },
                    onClick = {
                        coroutineScope.launch{
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Home.screen){
                            popUpTo(0)
                        }
                    })
                NavigationDrawerItem(
                    label = { Text(text = "Profile") },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile") },
                    onClick = {
                        coroutineScope.launch{
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screen){
                            popUpTo(0)
                        }
                    })
                NavigationDrawerItem(
                    label = { Text(text = "Settings") },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings") },
                    onClick = {
                        coroutineScope.launch{
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Settings.screen){
                            popUpTo(0)
                        }
                    })

                NavigationDrawerItem(
                    label = { Text(text = "Logout") },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Filled.ExitToApp, contentDescription = "Logout") },
                    onClick = {
                        coroutineScope.launch{
                            drawerState.close()
                        }
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                    })
                }
        },
        ){
        Scaffold (
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar(title = { Text(text = "Arcana") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Beige,
                        titleContentColor = Color.Black,
                        navigationIconContentColor = Color.Black
                    ),
                    navigationIcon = {
                        IconButton(onClick = {
                            coroutineScope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(Icons.Rounded.Menu, contentDescription = "MenuButton")
                        }

                    },
                )
            }
        ){
            NavHost(navController = navigationController, startDestination = Screens.Home.screen){
                composable(Screens.Home.screen){ Home()}
                composable(Screens.Profile.screen){ Profile()}
                composable(Screens.Settings.screen){ Settings()}
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LearnNavDrawerPreview() {
    ComposeTheme {
        LearnNavDrawer()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar(){
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember{
        mutableStateOf(false)
    }

    Scaffold (
        bottomBar = {
            BottomAppBar (
                containerColor = Beige
            ){
                IconButton(onClick = {
                    selected.value = Icons.Default.Home
                    navigationController.navigate(Screens.Home.screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Home, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.Black else Color.Gray)
                }
                IconButton(onClick = {
                    selected.value = Icons.Default.Person
                    navigationController.navigate(Screens.Profile.screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.Black else Color.Gray)
                }
                IconButton(onClick = {
                    selected.value = Icons.Default.Settings
                    navigationController.navigate(Screens.Settings.screen) {
                        popUpTo(0)
                    }
                }, modifier = Modifier.weight(1f)) {
                    Icon(Icons.Default.Settings, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.Black else Color.Gray)
                }

                Box(modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
                    contentAlignment = Alignment.Center){
                    FloatingActionButton(
                        onClick = { showBottomSheet = true }) {
                        Icon(Icons.Default.Add, contentDescription = null, tint = Beige)
                    }
                }
            }
            }
    ){ paddingValues ->
        NavHost(navController = navigationController,
            startDestination = Screens.Home.screen,
            modifier = Modifier.padding(paddingValues)){
            composable(Screens.Home.screen){ Home()}
            composable(Screens.Profile.screen){ Profile()}
            composable(Screens.Settings.screen){ Settings()}
            composable(Screens.Notification.screen){ Notification()}
            composable(Screens.Post.screen){ Post()}
        }
    }

    if(showBottomSheet){
        ModalBottomSheet(onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState
        ){
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
                ){
                BottomSheetItem(Icons.Default.ThumbUp, "Create New Post"){
                    showBottomSheet = false
                    navigationController.navigate(Screens.Post.screen){
                        popUpTo(0)
                    }
                }
                BottomSheetItem(Icons.Default.Star, "Add New Story"){
                    Toast.makeText(context, "Add New Story", Toast.LENGTH_SHORT).show()
                }
                BottomSheetItem(Icons.Default.PlayArrow, "Create New Reel"){
                    Toast.makeText(context, "Create New Reel", Toast.LENGTH_SHORT).show()
                }
                BottomSheetItem(Icons.Default.Favorite, "Go Live"){
                    Toast.makeText(context, "Go Live", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun BottomSheetItem(icon: ImageVector, title: String, onClick: () -> Unit){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.clickable { onClick() }
    ){
        Icon(icon, contentDescription = null, tint = Beige)
        Text(text = title, color = Beige, fontSize = 22.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun MyBottomAppBarPreview() {
    ComposeTheme {
        MyBottomAppBar()
    }
}

