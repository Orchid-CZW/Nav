<template>
  <div class="mod-menu">
    <el-row>
      <template v-for="menu in menuList">
        <el-button type="success" plain :key="menu.id" @click="getDataListById(menu.id)">{{menu.title}}</el-button>
      </template>
    </el-row>
    <!-- <el-menu  mode="horizontal" >
      <template v-for="menu in menuList">
        <el-menu-item index="1" :key="menu.id" @click="getDatalist()">{{menu.title}}</el-menu-item>
      </template>
    </el-menu> -->
    <!-- <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.categoryId" placeholder="分类" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
      </el-form-item>
    </el-form> -->
    <el-table
      :data="dataList"
      row-key="menuId"
      border
      style="width: 100%; ">
      <!-- <el-table-column prop="id" header-align="center" align="center" label="id"></el-table-column> -->
      <!-- <el-table-column prop="categoryId" header-align="center" align="center" label="分类编号"></el-table-column> -->
      <el-table-column prop="title" header-align="center" align="center" label="标题"></el-table-column>
      <!-- <el-table-column prop="photo" header-align="center" align="center" label="图片"></el-table-column> -->
      <el-table-column prop="description" header-align="center" align="center" label="描述"></el-table-column>
      <el-table-column prop="url" header-align="center" align="center" label="网址"></el-table-column>
      <!-- <el-table-column prop="createTime" header-align="center" align="center" label="创建时间"></el-table-column> -->
      <!-- <el-table-column prop="updateTime" header-align="center" align="center" label="更新时间"></el-table-column> -->
      <el-table-column prop="isDeleted" header-align="center" align="center" label="状态">
        <template slot-scope="scope">
          <el-switch
            v-model="scope.row.isDeleted"
            active-color="#13ce66"
            inactive-color="#ff4949"
            :active-value="0"
            :inactive-value="1"
          ></el-switch>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[3,10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    </div>
</template>

<script>
  export default {
    data () {
      return {
        dataForm: {
          categoryId: ''
        },
        dataList: [],
        menuList: [],
        pageIndex: 1,
        pageSize: 3,
        totalPage: 0,
        dataListLoading: false
      }
    },
    activated () {
      this.getDataList(),
      this.getMenuList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl(`/navigation/site/list`),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'categoryId': this.dataForm.categoryId
          })
        }).then(({data}) => {
          if (data) {
            this.dataList = data.page.list;
            this.totalPage = data.page.totalCount;
          } else {
            this.dataList = [];
            this.totalPage = 0;
          }
          this.dataListLoading = false;
        })
      },
      // 获取数据列表
      getDataListById (categoryId) {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl(`/navigation/site/list`),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'categoryId': categoryId
          })
        }).then(({data}) => {
          if (data) {
            this.dataList = data.page.list;
            this.totalPage = data.page.totalCount;
          } else {
            this.dataList = [];
            this.totalPage = 0;
          }
          this.dataListLoading = false;
        })
      },
      // 获取菜单列表
      getMenuList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl(`/navigation/category/list`),
          method: 'get',
          params: this.$http.adornParams({
            'limit': 12
          })
        }).then(({data}) => {
          if (data) {
            this.menuList = data.page.list;
          } else {
            this.menuList = [];
          }
          this.dataListLoading = false;
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      }
    }
  }
</script>

<style>
  .mod-home {
    line-height: 1.5;
  }
</style>

