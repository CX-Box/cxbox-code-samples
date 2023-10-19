const CracoLessPlugin = require('craco-less')

const lessModifyVars = {}

module.exports = {
    plugins: [
        {
            plugin: CracoLessPlugin,
            options: {
                cssLoaderOptions: {
                    modules: {
                        auto: resourcePath => !resourcePath.includes('node_modules'),
                        localIdentName: '[name]__[local]___[hash:base64:5]'
                    }
                },
                lessLoaderOptions: {
                    lessOptions: {
                        modifyVars: lessModifyVars,
                        javascriptEnabled: true
                    }
                }
            }
        }
    ],
    webpack: {}
}
